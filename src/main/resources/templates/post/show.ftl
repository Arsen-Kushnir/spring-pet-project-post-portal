<!doctype html>
<html lang="en">
<head>
    <#include "../include/coreDependencies.ftl">
    <title>Create new post</title>
</head>
<body class="d-flex flex-column min-vh-100 bg-light">

    <#include "../include/header.ftl">

    <div class="container">
        <div class="card text-center mt-5">
            <div class="card-header">
                <h2>${post.title}</h2>
            </div>
            <img src="${post.pictureUrl}" class="rounded mx-auto d-block mt-3" width="380vh" height="200vh" >
            <div class="card-body">
                <p class="card-text mt-2">${post.fullText}</p>
            </div>

            <#if user??>
                <div class="d-flex justify-content-center py-3">
                    <ul class="nav nav-pills">
                        <li class="nav-item m-2">
                            <a href="/posts/update/${post.id}" class="btn btn-warning">Update</a>
                        </li>
                        <li class="nav-item m-2">
                            <form method="POST" action="/posts/delete/${post.id}">
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                <button type="submit" class="btn btn-danger">Delete</button>
                            </form>
                        </li>
                    </ul>
                </div>
            </#if>

            <div class="card-footer text-muted">
                <#assign localTime = post.createdAt.toLocalTime() />
                <p class="blog-post-meta">${post.createdAt.toLocalDate()} ${localTime.getHour()}:${localTime.getMinute()} by <a href="#">${post.authorFullName}</a></p>
            </div>
        </div>
    </div>

    <#include "../include/footer.ftl">

</body>
</html>