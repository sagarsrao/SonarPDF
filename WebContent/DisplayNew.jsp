<%@ page import="java.sql.*" %>

<% Class.forName("com.mysql.jdbc.Driver"); %>

<HTML>
    <HEAD>
        <TITLE>Selecting Publishers From a Database</TITLE>
    </HEAD>

    <BODY>
        <H1>Selecting Publishers From a Database</H1>

        <% 
            Connection connection = DriverManager.getConnection(
              "jdbc:mysql://localhost:3306/sonar", "root", "");

            Statement statement = connection.createStatement() ;
            ResultSet resultset = statement.executeQuery("select name,project_uuid from projects where projects.scope = 'PRJ' ") ; 
        %>

        <TABLE BORDER="1">
            <TR>
                <TH>ProjectName</TH>
                <TH>ProjectID</TH>
                <TH>ProjectLink</TH>
                
            </TR>
            <% while(resultset.next()){ %>
            <TR>
                <TD> <%= resultset.getString("name") %></td>
                <TD> <%= resultset.getString("project_uuid") %></TD>
                <td><input type="button" value="ExportData" onclick="location.href='PdfReport'"/></td>  
                
            </TR>
            <% } %>
        </TABLE>
    </BODY>
</HTML>