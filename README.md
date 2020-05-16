读取数据库信息，用于工作

---
1、根据创建的表生成指定的模板的后端代码
（1）建立`Docker`版的数据库
```shell 
docker run -p 3306:3306 --name generatorMysql \
    -v /Users/wangjie_fourth/software/program/dockerData/generatorMysql/log:/var/log/mysql \
    -v /Users/wangjie_fourth/software/program/dockerData/generatorMysql/data:/var/lib/mysql \
    -v /Users/wangjie_fourth/software/program/dockerData/generatorMysql/conf:/etc/mysql \
    -e MYSQL_ROOT_PASSWORD=root  \
    -d mysql:5.7
```

(2)进入数据库，并创建数据
```sql
docker exec -it generatorMysql mysql -uroot -p
```
输入密码：root
```sql
CREATE DATABASE generator_test character set utf8;
```