# nanten
The public technical resources contributed by nanten.cc
This stapler-jelly-demo illustrates how stapler staple urls to jelly page or object method.

1. Deploy the project to tomcat.
2. Try following URLs and have a fun.
   /                    | served by demo/BookStore/index.jelly and call bookStore.getMyString() whithin jelly page ${it.myString}
   /config              | served by demo/BookStore/config.jelly and call bookStore.getMyString() whithin jelly page ${it.myString}
   /myString            | served by demo/BookStore/myString.jelly and call bookStore.getMyString() whithin jelly page ${it.myString}
   /noJelly             | served by bookStore.doNoJelly() and return a string to browser
   /items/book          | served by bookStore.getItems(), then a book object returned, then get demo/item/Book/index.jelly to display
   /items/book/book     | served by bookStore.getItems(), then a book object returned, then get demo/item/Book/book.jelly to display
   /items/book/author   | served by bookStore.getItems(), then a book object, then a author returned(since no author.jelly nor doAuthor()), then get demo/person/Author/index.jelly to display.
   /item/bascketball    | served by bookStore.getItem(), then a book object returned(startWith("b")), then get demo/item/Book/index.jelly to display
   /item/bowling/author | same as /items/book/author
   /items/cd            | served by bookStore.getItems(), then a cd object returned, then get demo/item/CD/index.jelly to display
   /items/cd/play       | served by bookStore.getItems(), then a cd object returned, then cd.doPlay() is called(no play.jelly nor any getPlay()), and return a string to browser
   /item/yundi          | served by bookStore.getItem(), then a cd object returned(not startWith("b")), then get demo/item/CD/index.jelly to display
   /item/yundi/play     | same as /items/cd/play


The way Stapler works is some what like Expression Language; it takes an object and URL, then evaluate the URL against the object. It repeats this process until it hits either a static resource, a view (such as JSP, Jelly, Groovy, etc.), or an action method.

This process can be best understood as a recursively defined mathematical function evaluate(node,url). For example, the hypothetical application depicted in the "getting started" document could have an evaluation process like the following:


Scenario: browser sends "POST /project/jaxb/docsAndFiles/upload HTTP/1.1"

   evaluate(<root object>, "/project/jaxb/docsAndFiles/upload")
-> evaluate(<root object>.getProject("jaxb"), "/docsAndFiles/upload")
-> evaluate(<jaxb project object>, "/docsAndFiles/upload")
-> evaluate(<jaxb project object>.getDocsAndFiles(), "/upload")
-> evaluate(<docs-and-files-section-object for jaxb>, "/upload")
-> <docs-and-files-section-object for jaxb>.doUpload(...)
The exact manner of recursion depends on the signature of the type of the node parameter, and the following sections describe them in detail. Also see a document in Hudson that explains how you can see the actual evaluation process unfold in your own application by monitoring HTTP headers.

URLs mapped to jelly page or object mehod. The jelly page is somewhat like a field of a object and can call method of that object in manner of ${it.name} in it. URL ends with /:
1. the index.jelly page
2. the doIndex() method
URL ends with path:
1. the name.jelly page
2. the doName.jelly method

Reference:
http://stapler.kohsuke.org/what-is.html
http://stapler.kohsuke.org/getting-started.html
http://stapler.kohsuke.org/reference.html
