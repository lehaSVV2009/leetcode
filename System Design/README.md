# System design

## Steps

1. Ask about how it is going to be used
2. Describe feature set
3. Ask about scaling (how many potential users, should we care, how much time/money do we have)
4. Draw high-level component structure
5. Think about complex parts of system (API schema/DB schema/algorithms/...)
6. Scaling (vertical/horizontal/caching/load balancing/replications/...)
7. Estimates/Prices

## Practice

### Pastebin

Design Pastebin, a website where you can store and share text online for a set period of time.

Note: Bit.ly is a similar service, with the distinction that Pastebin requires storing the paste contents instead of the original unshortened URL.

**Features scope**

- Create a link
- Immutable text
- See text by this link
- No authentication

**Constraints**

- Maximum period of time - 1 month
- Just text? encoding? -
- Limit of text - 1000 chars
- How many users I expect? - 1000...10 millions
- How many links can be created per second by single ip-user? 5
- How much data I expect? -
  FROM 1000*10*1000\*4b = 40MB per day => 1GB per month
  TO => 10TB per month

**API design**

```
POST mysite.by/notes { text: 'bblblladsasd' }
{
  url: 'mysite.by/notes/23basda',
  expired_at: 'iso8601'
}
```

GET mysite.by/notes/23basda { text: 'bblblladsasd' }

**Data model**

```
{
  id: long,
  text: varchar(1000),
  shared_key: varchar(10) unique,
  created_at: date,
  deleted_at: date
}
```

**Pseudo code components**

random('0-9A-Z') -> 123456
retry after transaction

UI -> API -> DB

![Pastebin](./pastebin.jpg)

https://sketchboard.me/pBPw4RPhzoAJ#/

### Scale on the Cloud

**Features scope**

Request -> Processing -> Store -> Response
e.g. user clicks to red or blue button, it sends to our DB.

Let's assume that we have simple application with 1 endpoint. API is deployed to single AWS EC2, DB is deployed to strong machine with AWS RDS

P.S. Actually, if application has just one endpoint, I would probably try AWS Lambda. It might be cheaper.

**API design**

POST /clicks { color: 'red' } -> process smth (take ip, find)

**Data model/schema**

Clicks: { id: long, ip: string, color: string, created_at: date }

**How to scale?**

Vertically (add memory and CPU to API and DB machines)

Horizontally

For API

1. Load balancer and several API instances on separate machines. It will detects requests of API.
2. Monitoring tool for applications and machines.
3. Some kind of reverse-proxy at the first layer to protect from attacks.
4. Probably some kind of autoscaling (like Kubernetes does) to stop unused machines and run new machine if load is too large.
5. Add EC2 on different zones according to the audience
6. Make code working in parallel if possible
   (No microservices, cause endpoint is single)

For DB

1. Choose valid DB according to use-cases (postgres/mongo/clickhouse/...)
2. Configure DB well (valid DB for the case, indexes, tested max_connection limit, backups)
3. Replication via any option (master-master/master-workers/...)
4. Shard (store different parts of DB in different machines)

P.S. If response is not important to be urgent, we can use queue like Kafka or whatever to do some processing afterwards and send response like 202 (Accepted)

**Development time**

Simple app (API + DB locally) - 1d
Set up AWS (roles/networks/ec2/rds) - 1w
Configure DB on AWS RDS - 2d
Configure app deployment to AWS EC2 - 3d

Later:
Load balancer - 3d
Monitoring - 1w
Apps auto-scaling - 1w
DB replications - 1w
DB sharding - 1w

**Reference links**

- Best link ever - https://github.com/donnemartin/system-design-primer/tree/master/solutions/system_design/scaling_aws#design-a-system-that-scales-to-millions-of-users-on-aws
- AWS EC2 Pricing - https://aws.amazon.com/ec2/pricing/
- AWS RDS Pricing - https://aws.amazon.com/rds/pricing/
- AWS Load Balancer Pricing - https://aws.amazon.com/elasticloadbalancing/pricing/
- AWS CloudWatch Pricing - https://aws.amazon.com/ru/cloudwatch/pricing/
- AWS EKS Pricing - https://aws.amazon.com/ru/eks/pricing/
- AWS Read Replica Pricing - https://aws.amazon.com/rds/details/read-replicas/
- AWS Backup Pricing - https://aws.amazon.com/backup/pricing/

**Diagrams**

![Scale on the cloud](./scale_on_the_cloud.jpg)

https://sketchboard.me/fBPw8sGVGNvl#/

### Google Photos

How to use:

- Web + Mobile

Use cases:

- Add photo
  ![Add photo](./google_photos_add_photo.jpg)
- See recent photos
  ![Recent photos](./google_photos_recent_photos.jpg)
- Share photo
  ![Share photo](./google_photos_share_photos.jpg)
- See shared photos
  ![Shared photos](./gooogle_photos_shared_photos.jpg)
- Pricing
  ![Pricing](./google_photos_pricing.jpg)

Main difficulties:

- How to handle too large distributed file storage?
- What to do with too many old photos rows to not load DB (cold storage?)
- How to enable so many connections for upload?
- How to connect file upload with queue?

### Civilization Web

How to use:

- Web online vs Bot

Use cases:

- Create game
- Join game
- Remove game
- See generated map
- Have only settlers
- Move settlers
- Build cities
- Build settlers
- Expand city
- End turn
- Bot

![Civilization System Design](./civilization.jpeg)

Main difficulties:

- Non-mindless bot
- Draw beautiful map
- Connect moves/actions with turn
- Logic to expand city/move units
- Win condition

### Instagram Stories

![Instagram Stories System Design](./instagram_stories.jpg)

https://leetcode.com/discuss/interview-question/system-design/350261/Facebook-or-Design-an-instagram-stories-app-for-iOS

- Link path of uploaded file with user story in DB, as well as `animation_type` + `animation_position` and `created_date`

### Splitwise

https://leetcode.com/discuss/interview-question/system-design/306519/System-Design-or-Splitwise

- Complexity is in algorithm (how to split 500 USD between 7 people)
- You can store table with current user status (expenses) and separate table with debts
- `{ type: 'half', payers: [{ user_id: 1, sum: 250, currency: 'USD' }], debtors: [{ user_id: 2 }, { user_id: 3 }] }`

### Coupon/voucher system

https://leetcode.com/discuss/interview-question/system-design/353302/Design-a-couponvoucher-management-system-or-DellEMC

- Always look at date columns like `assigned_at`

### Url shortener

https://leetcode.com/discuss/interview-question/system-design/124658/Design-URL-Shortening-service-like-TinyURL

- Generate random `short_key` like `abc46f`, it will allow to use `(10+33)^6` options
- Retry if `short_key` is already in DB (e.g. `short_key` has `unique` constrain in DB)
- If there are too many retries, increase `short_key` length to 1, `(10+33)^7` options
- Monitor DB memory, think about sharding if there are too many

## Resources

- How to Succeed in a System Design Interview - https://blog.pramp.com/how-to-succeed-in-a-system-design-interview-27b35de0df26
- Cheat sheet - https://gist.github.com/vasanthk/485d1c25737e8e72759f
