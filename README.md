
# Cakum pakum
This is a REST starter project with some nice defaults.  
It uses H2 in-memory db, Lombok and Swagger.  


## Lombok installation

- download & run JAR, it detects Eclipse i installs Lombok
- close and open Eclipse (not File -> Restart!!!)
- turn on **Annotation Processing** on project

---

## Code style
- Preferences -> Java -> Code Style -> Formatter -> Import
- select SakeStyle & Apply

### Code formatting
- `Ctrl+Shift+F` formats *only opened file* or *selected code snippet*
- Right click project -> Source -> Format

---

## Database

- go to http://localhost:8080/h2-console
- connect to `jdbc:h2:mem:testdb`, username: `sa`, password: ``

```sql
SELECT * FROM BLOG_POST ;
SELECT * FROM BLOG_POST_COMMENTS ;
SELECT * FROM COMMENT ;
```

---

## REST

See Postman collection for examples.  
Or go to `http://localhost:8080/swagger-ui.html`






