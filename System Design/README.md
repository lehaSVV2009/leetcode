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

### Civilization Web

How to use:
* Web online vs Bot

Use cases:
* Create game
* Join game
* Remove game
* See generated map
* Have only settlers
* Move settlers
* Build cities
* Build settlers
* Expand city
* End turn
* Bot

![Civilization System Design](./civilization.jpeg)

Main difficulties:
* Non-mindless bot
* Draw beautiful map
* Connect moves/actions with turn
* Logic to expand city/move units
* Win condition

### Instagram Stories

![Instagram Stories System Design](./instagram_stories.jpg)

https://leetcode.com/discuss/interview-question/system-design/350261/Facebook-or-Design-an-instagram-stories-app-for-iOS

* Link path of uploaded file with user story in DB, as well as `animation_type` + `animation_position` and `created_date`

### Splitwise

https://leetcode.com/discuss/interview-question/system-design/306519/System-Design-or-Splitwise

* Complexity is in algorithm (how to split 500 USD between 7 people)
* You can store table with current user status (expenses) and separate table with debts
* `{ type: 'half', payers: [{ user_id: 1, sum: 250, currency: 'USD' }], debtors: [{ user_id: 2 }, { user_id: 3 }] }`

### Coupon/voucher system

https://leetcode.com/discuss/interview-question/system-design/353302/Design-a-couponvoucher-management-system-or-DellEMC

* Always look at date columns like `assigned_at`

### Url shortener

https://leetcode.com/discuss/interview-question/system-design/124658/Design-URL-Shortening-service-like-TinyURL

* Generate random `short_key` like `abc46f`, it will allow to use `(10+33)^6` options
* Retry if `short_key` is already in DB (e.g. `short_key` has `unique` constrain in DB)
* If there are too many retries, increase `short_key` length to 1, `(10+33)^7` options
* Monitor DB memory, think about sharding if there are too many

## Resources
* How to Succeed in a System Design Interview - https://blog.pramp.com/how-to-succeed-in-a-system-design-interview-27b35de0df26
* Cheat sheet - https://gist.github.com/vasanthk/485d1c25737e8e72759f