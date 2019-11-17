class Solution {
  // STOLEN!!!.. But the idea was right..
    // public int maxPoints(int[][] points) {
        // Same points?
        // Every 2 points have line bettween them
        // Linear functions
        // y = kx + b
        // [1, 1][2, 2] ? 2
        // [1, 1][2, 2][3, 3] ? 3
        // [1, 2][2, 3][3, 4] ? 3
        // [1, 4][2, 5][3, 6] ? 3
        // [1, 4][4, 7][7, 10] ? 3
        // [[1, 4],[2, 8],[4, 16]] ? 3
        // [1, 3]? 1
        // [[0,0],[1,1],[0,0]]? 3!!!
        // [[560,248],[0,16],[30,250],[950,187],[630,277],[950,187],[-212,-268],[-287,-222],[53,37],[-280,-100],[-1,-14],[-5,4],[-35,-387],[-95,11],[-70,-13],[-700,-274],[-95,11],[-2,-33],[3,62],[-4,-47],[106,98],[-7,-65],[-8,-71],[-8,-147],[5,5],[-5,-90],[-420,-158],[-420,-158],[-350,-129],[-475,-53],[-4,-47],[-380,-37],[0,-24],[35,299],[-8,-71],[-2,-6],[8,25],[6,13],[-106,-146],[53,37],[-7,-128],[-5,-1],[-318,-390],[-15,-191],[-665,-85],[318,342],[7,138],[-570,-69],[-9,-4],[0,-9],[1,-7],[-51,23],[4,1],[-7,5],[-280,-100],[700,306],[0,-23],[-7,-4],[-246,-184],[350,161],[-424,-512],[35,299],[0,-24],[-140,-42],[-760,-101],[-9,-9],[140,74],[-285,-21],[-350,-129],[-6,9],[-630,-245],[700,306],[1,-17],[0,16],[-70,-13],[1,24],[-328,-260],[-34,26],[7,-5],[-371,-451],[-570,-69],[0,27],[-7,-65],[-9,-166],[-475,-53],[-68,20],[210,103],[700,306],[7,-6],[-3,-52],[-106,-146],[560,248],[10,6],[6,119],[0,2],[-41,6],[7,19],[30,250]]
        // [[0,0],[94911151,94911150],[94911152,94911151]]
        
        // Solution 1
        // take pair of points
        // get params for linear function
        // check other point is in function
        // [[1, 1],[2, 2],[3, 3]]
        // Line is a function y = f(x)
        // I try to find f(x)
        // 1 = 1
        // 2 = 2
        // => y = x
        // 3 = 3? yes. + line
        // [1, 4][2, 5][3, 6]
        // => y = x + 3
        // [1, 4][2, 8][4, 16] ? 3
        // => y = 4x
        // [1, 5][2, 9][4, 17] ? 3
        // => y = 4x + 1
        // 1 = 1 => y1 = y2
        // 2 = 2 => x1 = x2
        // y = kx + b
        // y1 = kx1 + b
        // y2 = kx2 + b
        // b = y1 - kx1
        // b = y2 - kx2
        // y1 - kx1 = y2 - kx2
        // kx2 - kx1 = y2 - y1
        // !!!
        // k = (y2 - y1) / (x2 - x1)
        // b = y1 - kx1
        // => if y3 == k*x3 + b then one line
        // foreach point
        //   foreach nextPoint
        //     lineCount = 0
        //     k = 
        //     b = 
        //     foreach nextNextPoint
        //       if y == kx + b
        //         lineCount++
        // O(N^3)
        
        // Solution 2
        // Same, but with hashmap
        // int maxCount
        // Map<Line, count>
        // foreach point
        //   foreach nextPoint
        //     lineCount = 0
        //     k = 
        //     b = 
        //     line = k + '_' + b
        //     count = map.getOrDefault(line, 1)
        //     count++
        //     if count > maxCount
        //       maxCount = count
        //     map.put(line, count)
        
        // y = kx + b
        // y1 = 6, x1 = 2 => 6 = k*2 + b
        // y2 = 4, x2 = 2 => 4 = k*2 + b
        // y1 = kx1 + b
        // y2 = kx2 + b
        
        // FAILED
        // | x
        // |   x
        // |  x
        // | xx
        // | 
        //  ----------
        // 4, but not 3

        
//         if (points.length <= 2) {
//             return points.length;
//         }
        
//         int result = 0;

//         for(int i = 0; i < points.length; i++){
//             HashMap<Double, Integer> map = new HashMap<Double, Integer>();
//             int sameX = 1;
//             int samePoint = 0;
            
//             int x1 = points[i][0];
//             int y1 = points[i][1];

//             for (int j = 0; j < points.length; j++) {
//                 if (j == i) {
//                     continue;
//                 }
//                 int x2 = points[j][0];
//                 int y2 = points[j][1];
                
//                 if ((x2 == x1) && (y2 == y1)){
//                     samePoint++;
//                 }
//                 if (x2 == x1){
//                     sameX++;
//                     continue;
//                 }

//                 double k = (double) (y2 - y1) / (double) (x2 - x1);
//                 if (map.containsKey(k)) {
//                     map.put(k, map.get(k) + 1);
//                 } else {
//                     map.put(k, 2);
//                 }
//                 result = Math.max(result, map.get(k) + samePoint);
//             }
//             System.out.println(map);
//             result = Math.max(result, sameX);
//         }

//         return result;
//     }
    
    Map<Object, Integer> mapx = new HashMap<>();
    Map<Object, Integer> mapy = new HashMap<>();
    Map<Object, Integer> mapxy = new HashMap<>();
    
    public int maxPoints(int[][] points) {
        int max;
        int maxxy = 0;

        for(int i = 0; i < points.length; i++) {
            int x = points[i][0];
            int y = points[i][1];
            putMap(x, mapx);
            putMap(y, mapy);
            mapxy.clear();
            int n = 0;
            for(int j = i+1; j < points.length; j++) {

                int x1 = points[j][0];
                int y1 = points[j][1];
                double reduceX = x1 - x;
                double reduceY = y1 - y;
                if(x1 == x && y1 == y) {
                    n++;
                }
                if(reduceX != 0 && reduceY != 0) {
                    putMap(reduceX/reduceY, mapxy);
                }


            }
            n +=  getMax(mapxy);
            if(maxxy < n) {
                maxxy = n;
            }
        }
        int maxx = getMax(mapx);
        int maxy = getMax(mapy);
        if(maxxy!=0) maxxy+=1;
        if(maxx > maxy) {
            max = maxx;
        }else {
            max = maxy;
        }
        if(max < maxxy) {
            max = maxxy;
        }

        return max;
    }
    public  void putMap(Object i, Map<Object, Integer> map) {
        Integer num = map.get(i);
        if(num != null) {
            map.put(i, num.intValue()+1);
        }else {
            map.put(i, 1);
        }
    }
    public  int getMax(Map<Object, Integer> map) {
        int max = 0;
        for(Object o : map.keySet()) {
            int num =  map.get(o);
            if(max < num) {
                max = num;
            }
        }
        return max;
    }
}