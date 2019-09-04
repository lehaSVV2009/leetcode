module.exports = { 
  //param A : string
  //return a array of strings
   prettyJSON : function(json){
         // Not a json?
         // Invalid json?
         // \t adds single identation or start/end
         // Can I use \t for all identations? Or just many spaces?
         // What about \' ?
         // Already intended?
         //
         // Characters to do end line: '{', '[', }, ], ','
         
         // Solution 1
         // identationLevel = 0
         // foreach 
         //   if ,
         //      line = \t * identationLevel + line + letter
         //      add line to result
         //      line = ''
         //      continue
         //   if {[
         //      line = \t * identationLevel + line
         //      add line to result
         //      line = \t * identationLevel + letter
         //      add line to result
         //      line = ''
         //      identationLevel++
         //      continue
         //   if ]}
         //      line = \t * identationLevel + line
         //      add line to result
         //      identationLevel--
         //      line = \t * identationLevel + letter
         //      add line to result
         //      continue
         //   line += letter
 
         // Solution 2
         // Go from both sides
         
         // Solution 3
         // Build a tree and then just format all of them
 
         function generateTabs(count) {
             var text = '';
             for (var j = 0; j < count; ++j) {
                 text += '\t';
             }
             return text;
         }
         
         json = json.replace(/\s/g, '');
 
         var lines = [];
 
         var identationLevel = 0;
         var line = '';
         for (var i = 0; i < json.length; ++i) {
             var letter = json.charAt(i);
             
             if (letter === '{' || letter === '[') {
                 if (line) {
                     lines.push(generateTabs(identationLevel) + line);
                 }
                 line = generateTabs(identationLevel) + letter;
                 lines.push(line);
                 line = '';
                 identationLevel++;
                 continue;
             }
             
             if (letter === ',') {
                 line = generateTabs(identationLevel) + line + letter;
                 lines.push(line);
                 line = '';
                 continue;
             }
             
             if (letter === '}' || letter === ']') {
                 if (line) {
                     lines.push(generateTabs(identationLevel) + line);
                 }
                 identationLevel--;
 
                 var hasNextComma = i + 1 < json.length && json.charAt(i + 1) === ','
                 if (hasNextComma) {
                     line = generateTabs(identationLevel) + letter + ',';
                     i++;
                 } else {
                     line = generateTabs(identationLevel) + letter;
                 }
                 lines.push(line);
                 line = '';
                 continue;
             }
             
             line += letter;
         }
 
         return lines;
   },
 };
 