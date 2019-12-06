<#import "parts/common.ftlh" as c>

<@c.page>
List of users
<table>
    <thead>
    <tr>
        <th>Name</th>
        <th>Role</th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <#list user as usr>
    <tr>
        <td>${usr.username}</td>
        <td><#list usr.roles as role>${role}<#sep>, </#list></td>
        <td><a href="/user/${usr.id}">edit</a></td>
    </tr>
    </#list>
    </tbody>
</table>
</@c.page>