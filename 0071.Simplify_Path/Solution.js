/**
 * @param {string} path
 * @return {string}
 */
var simplifyPath = function(path) {
  // meaningful characters : '.', '..', '/', '//', '///' ->
  // remove trailing slash

  // errors? /../first_level -> /first_level
  // 2 slashes? // replaced with single -> /
  // any illegal path characters? '/?/' -> '/?'
  // /../../ ? -> root folder
  // ... ? -> ''
  // /... ? -> '/...'
  // empty? -> ''
  // /? -> '/?'

  // Solution 1
  // stack
  //
  // stack = []
  // breadCrumbs = path.split('/[//]+/')
  // foreach breadCrumb
  //   if !breadCrumb || breadCrumb == '.' continue
  //   if breadCrumb == '..' stack.pop()
  //   else stack.push(breadCrumb)
  //  return '/' + stack.join('/')
  // O(N)
  // O(N)
  if (!path || path.length === 0 || path[0] !== "/") {
    return "";
  }

  var stack = [];
  var breadcrumbs = path.split("/");

  breadcrumbs.forEach(breadcrumb => {
    if (!breadcrumb || breadcrumb === ".") {
      return;
    }
    if (breadcrumb === "..") {
      stack.pop();
    } else {
      stack.push(breadcrumb);
    }
  });

  return "/" + stack.join("/");
};
