# stapler-jelly-demo of nanten.cc
The public technical resources contributed by nanten.cc

**This stapler-jelly-demo illustrates how stapler staple urls to jelly page or object method.**

1. Deploy the project to tomcat.
2. Try following URLs and have a fun.

   /  
   /config  
   /myString  
   /noJelly  
   /items/book  
   /items/book/book  
   /items/book/author  
   /item/bascketball  
   /item/bowling/author   
   /items/cd  
   /items/cd/play  
   /item/yundi  
   /item/yundi/play  
   /item/painting   
   /item/painting/callparent  
***
The way Stapler works is some what like Expression Language; it takes an object and URL, then evaluate the URL against the object. It repeats this process until it hits either a static resource, a view (such as JSP, Jelly, Groovy, etc.), or an action method.
This process can be best understood as a recursively defined mathematical function evaluate(node,url). 
***
See docs/Tutorial.txt for detailed explaination.

**Reference:**  
http://stapler.kohsuke.org/what-is.html  
http://stapler.kohsuke.org/getting-started.html  
http://stapler.kohsuke.org/reference.html  
