
# Cakum pakum
This is a REST starter project with some nice defaults.  

Open `http://localhost:8080/swagger-ui.html` to play with it.

## Lombok installation
Intellij users just install the Lombok plugin.  
Eclipse users:
- download & run JAR, it detects Eclipse i installs Lombok
- close and open Eclipse (not File -> Restart!!!)
- turn on **Annotation Processing** on project

---

## Code style
You can import and use the `eclipse-java-formatting-settings.xml` style (yes, Intellij supports it also).

---

## Database
This project is using H2 in-memory db.

- go to http://localhost:8080/h2-console
- connect to `jdbc:h2:mem:testdb`, username: `sa`, password: 

```sql
SELECT * FROM BLOG_POST ;
SELECT * FROM BLOG_POST_COMMENTS ;
SELECT * FROM COMMENT ;
```




