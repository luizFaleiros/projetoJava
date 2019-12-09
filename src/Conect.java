import java.sql.Connection;
import java.sql.DriverManager;

class Conect{
    private String host;
    private String port;
    private String schema;
    private String user;
    private String password;

    private Connection connection = null;  


    public Conect(String host, String port, String schema, String user, String password){
        this.setHost(host);
        this.setPort(port);
        this.setPassword(password);
        this.setSchema(schema);
        this.setUser(user);
        this.doConnection();
    }
    public Conect(){
        this.setHost("localhost");
        this.setPort("3306");
        this.setPassword("");
        this.setSchema("padaria");
        this.setUser("root");
        this.doConnection();
    }


    private void doConnection(){
        String timezone = "&useTimezone=true&serverTimezone=UTC";
        String url = "jdbc:mysql//"+this.host+":"+this.port+"/"+this.schema+"?user="+this.user+"&password="+this.password+timezone;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getConstructor().newInstance();
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            this.connection = DriverManager.getConnection(url);
        } catch (Exception e) {
            
        }
    }

    //getter and Setter

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public Connection getConnection(){
        return (this.connection);
    }
}