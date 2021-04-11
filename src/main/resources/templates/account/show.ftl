<!doctype html>
<html lang="en">
<head>
    <#include "../include/coreDependencies.ftl" >
    <title>Account</title>
</head>
<body class="d-flex flex-column min-vh-100">

    <#include "../include/header.ftl">

    <main class="container-fluid pb-3 pt-3">
        <div class="d-grid gap-3" style="grid-template-columns: 1fr 2fr;">

            <#include "./include/aside.ftl">

            <div class="bg-light border rounded-3 p-3">
                <article class="blog-post mt-5">
                    <h2 class="blog-post-title text-center mb-3">First name: <i>${user.firstName}</i>, Last name: <i>${user.lastName}</i></h2>
                    <h3 class="blog-post-title text-center mb-3">Age: <i>${user.age}</i></h3>
                    <#if user.role == "ROLE_ADMIN">
                        <h3 class="blog-post-title text-center mb-3">Role: <i>ADMIN</i></h3>
                    <#else>
                        <h3 class="blog-post-title text-center mb-3">Role: <i>USER</i></h3>

                    </#if>
                </article>
            </div>
        </div>
    </main>

    <#include "../include/footer.ftl">

</body>
</html>