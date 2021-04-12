<!doctype html>
<html lang="en">
<head>
    <#include "../include/coreDependencies.ftl" >
    <title>Post Portal</title>
</head>
<body class="d-flex flex-column min-vh-100">

    <#include "../include/header.ftl">

    <div class="album py-5 bg-light">
        <div class="container">
            <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">

                <#if posts?has_content>
                    <#list posts as post>
                        <div class="col">
                            <div class="card shadow-sm">
                                <img class="bd-placeholder-img card-img-top" width="100%" height="220px" src="${post.pictureUrl}" role="img">
                                <div class="card-body">
                                    <h3>${post.title}</h3>
                                    <p class="card-text">${post.anons}</p>
                                    <div class="d-flex justify-content-between align-items-center">
                                        <div class="btn-group">
                                            <a href="/main/posts/${post.id}" class="btn btn-sm btn-outline-secondary">View</a>
                                        </div>
                                        <#assign localTime = post.createdAt.toLocalTime() />
                                        <small class="text-muted">${post.createdAt.toLocalDate()} ${localTime.getHour()}:${localTime.getMinute()}</small>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </#list>
                <#else>
                    <div class="text-center w-100">
                        <h2>Sorry, but not found any posts!</h2>
                    </div>
                </#if>

            </div>
        </div>
    </div>

    <#include "../include/footer.ftl">

</body>
</html>