new Vue({
    el: '#app',
    data: function() {
        return {
            form: {
                packagePrefix: 'com.wangjie',
                tablePrefix: '',
                email: 'wangjie_fourth@163.com',
                author: 'wangjie',
            },
            tableData: [{
                tableName:"",
                tableEngine:"",
                tableNote:"",
                tableCreateTime:""
            }],
            selectTable:[],
            dialogVisible:false,
            modelCode:"",
        }
    },
    methods: {
        // 选中行时触发
        selectRows(selection, row){
            console.log("选中数据")
            this.selectTable = selection;
        },
        // 生成DTO代码
        generatorDTO(){
            if (this.selectTable.length === 0){
                this.$message({
                    message: '请选择表',
                    type: 'error'
                });
            }
            // 获取数据
            console.log("获取DTO模板代码")
            axios.post('http://localhost:8080/deyi/dto',{
                tableName:this.selectTable[0].tableName,
                tableNote:this.selectTable[0].tableNote,
                tablePrefix:this.form.tablePrefix,
                packagePrefix:this.form.packagePrefix,
                author:this.form.author,
                email:this.form.email
            })
                .then(response => {
                    console.log(response.data);
                    this.dialogVisible = true;
                    this.modelCode = response.data;
                })
                .catch(function (error) { // 请求失败处理
                    console.log(error);
                });
        },
        // 生成Manager代码
        generatorManager(){
            if (this.selectTable.length === 0){
                this.$message({
                    message: '请选择表',
                    type: 'error'
                });
            }
            // 获取数据
            console.log("获取manager模板代码")
            axios.post('http://localhost:8080/deyi/manager',{
                tableName:this.selectTable[0].tableName,
                tableNote:this.selectTable[0].tableNote,
                tablePrefix:this.form.tablePrefix,
                packagePrefix:this.form.packagePrefix,
                author:this.form.author,
                email:this.form.email
            })
                .then(response => {
                    console.log(response.data);
                    this.dialogVisible = true;
                    this.modelCode = response.data;
                })
                .catch(function (error) { // 请求失败处理
                    console.log(error);
                });
        },
        // 生成Entity代码
        generatorEntity(){
            if (this.selectTable.length === 0){
                this.$message({
                    message: '请选择表',
                    type: 'error'
                });
            }
            // 获取数据
            console.log("获取entity模板代码")
            axios.post('http://localhost:8080/deyi/entity',{
                tableName:this.selectTable[0].tableName,
                tableNote:this.selectTable[0].tableNote,
                tablePrefix:this.form.tablePrefix,
                packagePrefix:this.form.packagePrefix,
                author:this.form.author,
                email:this.form.email
            })
                .then(response => {
                    console.log(response.data);
                    this.dialogVisible = true;
                    this.modelCode = response.data;
                })
                .catch(function (error) { // 请求失败处理
                    console.log(error);
                });
        },
        // 生成Mapper.java代码
        generatorMapperJ(){
            if (this.selectTable.length === 0){
                this.$message({
                    message: '请选择表',
                    type: 'error'
                });
            }
            // 获取数据
            console.log("获取生成MapperJ模板代码")
            axios.post('http://localhost:8080/deyi/mapper-java',{
                tableName:this.selectTable[0].tableName,
                tableNote:this.selectTable[0].tableNote,
                tablePrefix:this.form.tablePrefix,
                packagePrefix:this.form.packagePrefix,
                author:this.form.author,
                email:this.form.email
            })
                .then(response => {
                    console.log(response.data);
                    this.dialogVisible = true;
                    this.modelCode = response.data;
                })
                .catch(function (error) { // 请求失败处理
                    console.log(error);
                });
        },
        // 生成Mapper.xml代码
        generatorMapperX(){
            if (this.selectTable.length === 0){
                this.$message({
                    message: '请选择表',
                    type: 'error'
                });
            }
            // 获取数据
            console.log("获取mapper.xml模板代码")
            axios.post('http://localhost:8080/deyi/mapper-xml',{
                tableName:this.selectTable[0].tableName,
                tableNote:this.selectTable[0].tableNote,
                tablePrefix:this.form.tablePrefix,
                packagePrefix:this.form.packagePrefix,
                author:this.form.author,
                email:this.form.email
            })
                .then(response => {
                    console.log(response.data);
                    this.dialogVisible = true;
                    this.modelCode = response.data;
                })
                .catch(function (error) { // 请求失败处理
                    console.log(error);
                });
        },
        // 生成Service代码
        generatorService(){
            if (this.selectTable.length === 0){
                this.$message({
                    message: '请选择表',
                    type: 'error'
                });
            }
            // 获取数据
            console.log("获取service模板代码")
            axios.post('http://localhost:8080/deyi/service',{
                tableName:this.selectTable[0].tableName,
                tableNote:this.selectTable[0].tableNote,
                tablePrefix:this.form.tablePrefix,
                packagePrefix:this.form.packagePrefix,
                author:this.form.author,
                email:this.form.email
            })
                .then(response => {
                    console.log(response.data);
                    this.dialogVisible = true;
                    this.modelCode = response.data;
                })
                .catch(function (error) { // 请求失败处理
                    console.log(error);
                });
        },
        // 生成Controller代码
        generatorController(){
            if (this.selectTable.length === 0){
                this.$message({
                    message: '请选择表',
                    type: 'error'
                });
            }
            // 获取数据
            console.log("获取controller模板代码")
            axios.post('http://localhost:8080/deyi/controller',{
                    tableName:this.selectTable[0].tableName,
                    tableNote:this.selectTable[0].tableNote,
                    tablePrefix:this.form.tablePrefix,
                    packagePrefix:this.form.packagePrefix,
                    author:this.form.author,
                    email:this.form.email
                })
                .then(response => {
                    console.log(response.data);
                    this.dialogVisible = true;
                    this.modelCode = response.data;
                })
                .catch(function (error) { // 请求失败处理
                    console.log(error);
                });
        },
        // 查询当前数据库下所有表信息
        getTableList(){
            axios
                .get('http://localhost:8080/deyi/list')
                .then(response => {
                    console.log(response);
                    this.tableData = response.data;
                })
                .catch(function (error) { // 请求失败处理
                    console.log(error);
                });
        }
    },
    created(){
        console.log("初始化页面")
        // 查询当前数据库下的所有表信息
        this.getTableList();
    }
})