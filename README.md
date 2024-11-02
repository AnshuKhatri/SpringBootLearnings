MongoDBDemo : - 
application.properties : put the username and the password in the url for the connection
Main class MongoDbDemoApplication implements CommandLineRunner 
Controller: <localhost/getStudentInfo> : Flow<StudentController -> StudentService -> StudentRepo:showAllStudents->findAll()>
