<!doctype html>
<html lang="en">
<head>
    <#include "../include/coreDependencies.ftl">
    <title>Update new post</title>
</head>
<body class="d-flex flex-column min-vh-100 bg-light">

<#include "../include/header.ftl">

<div class="container">
    <section class="py-3 text-center container">
        <div class="row py-lg-5">
            <div class="col-lg-6 col-md-8 mx-auto">
                <h1 class="fw-light">Update post!</h1>
            </div>
        </div>
    </section>
    <div class="album py-2">
        <div class="container">
            <form method="POST">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

                <div class="m-3">
                    <label for="title" class="form-label">Title:</label>
                    <input type="text" class="form-control" name="title" id="title" placeholder="Write title here..." value="${post.title}">
                    <#if titleError??>
                        <div class="form-text text-center">${titleError}</div>
                    </#if>
                </div>

                <div class="m-3">
                    <label for="anons" class="form-label">Anons:</label>
                    <input type="text" class="form-control" name="anons" id="anons" placeholder="Write anons here..." value="${post.anons}">
                    <#if anonsError??>
                        <div class="form-text text-center">${anonsError}</div>
                    </#if>
                </div>

                <div class="m-3">
                    <label for="full_text" class="form-label">Full text for post:</label>
                    <textarea class="form-control" name="fullText" id="full_text" rows="5" placeholder="Write full text here...">${post.fullText}</textarea>
                    <#if fullTextError??>
                        <div class="form-text text-center">${fullTextError}</div>
                    </#if>
                </div>
                <div class="form-row text-center">
                    <button type="submit" class="btn btn-success m-3 p-2 w-50 center-block">Update</button>
                </div>
            </form>
        </div>
    </div>
</div>

<#include "../include/footer.ftl">

</body>
</html>