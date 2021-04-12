<!doctype html>
<html lang="en">
<head>
    <#include "../include/coreDependencies.ftl">
    <title>Create new post</title>
</head>
<body class="d-flex flex-column min-vh-100 bg-light">

    <#include "../include/header.ftl">

    <div class="container">
        <section class="py-3 text-center container">
            <div class="row py-lg-2">
                <div class="col-lg-6 col-md-8 mx-auto">
                    <h1 class="fw-light">Create new post!</h1>
                </div>
            </div>
        </section>
        <div class="album py-2">
            <div class="container">
                <form method="POST" action="/posts">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

                    <div class="m-3">
                        <label for="title" class="form-label">Title:</label>
                        <input type="text" class="form-control" name="title" id="title" placeholder="Write title here...">
                        <#if titleError??>
                            <div class="form-text text-center">${titleError}</div>
                        </#if>
                    </div>

                    <div class="m-3">
                        <label for="anons" class="form-label">Anons:</label>
                        <input type="text" class="form-control" name="anons" id="anons" placeholder="Write anons here...">
                        <#if anonsError??>
                            <div class="form-text text-center">${anonsError}</div>
                        </#if>
                    </div>

                    <div class="m-3">
                        <label for="full_text" class="form-label">Full text for post:</label>
                        <textarea class="form-control" name="fullText" id="full_text" rows="5" placeholder="Write full text here..."></textarea>
                        <#if fullTextError??>
                            <div class="form-text text-center">${fullTextError}</div>
                        </#if>
                    </div>
                    <div class="row p-3 d-flex align-items-center">
                        <div class="col-9 h-50 input-group d-flex align-items-center">
                            <div class="input-group-prepend d-flex align-items-center">
                                <span class="input-group-text">Main picture: </span>
                            </div>
                            <input type="url" class="form-control" id="image-url" name="pictureUrl" required placeholder="Link to picture...">
                        </div>
                        <div class="col h-100 mt-3">
                            <div id="image-preview-block">
                                <img src="" class="mw-50 mh-50 rounded mx-auto d-block" id="image-display" alt="Попередній перегляд зображення">
                            </div>
                            <div id="image-loading-error">
                                <div class="h5 text-center">Picture not found!</div>
                            </div>
                            <script>
                                let imageUrl = $('#image-url');
                                let imageDisplay = $('#image-display');
                                let imagePreviewBlock = $('#image-preview-block');
                                let imageLoadingErrorBlock = $('#image-loading-error');
                                let setImageSrcUrl = function () {
                                    imageDisplay.attr('src', imageUrl.val())
                                };
                                $(document).ready(setImageSrcUrl);
                                imageUrl.change(setImageSrcUrl);
                                imageDisplay
                                    .on('load', function () {
                                        imagePreviewBlock.show();
                                        imageLoadingErrorBlock.hide();
                                        $('#btn-submit').attr('disabled', false);
                                    })
                                    .on('error', function () {
                                        imagePreviewBlock.hide();
                                        imageLoadingErrorBlock.show();
                                        $('#btn-submit').attr('disabled', true);
                                    });
                            </script>

                        </div>
                    </div>
                    <div class="form-row text-center">
                        <button type="submit" id="btn-submit" class="btn btn-success m-3 p-2 w-50 center-block">Create</button>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <#include "../include/footer.ftl">

</body>
</html>