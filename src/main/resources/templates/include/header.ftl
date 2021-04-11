<header class="p-3 bg-dark text-white">
    <div class="container">
        <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
            <a href="/" class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none">
                <img class="bi me-2" width="50" height="42" src="/images/logo.png"/>
            </a>

            <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                <li><a href="/" class="nav-link px-2 text-white">Home</a></li>
                <li><a href="/posts/new" class="nav-link px-2 text-white">Add post</a></li>
                <li><a href="/accounts/index" class="nav-link px-2 text-white">Account</a></li>
                <li><a href="/about" class="nav-link px-2 text-white">About</a></li>
            </ul>

            <form method="GET" action="/posts/search" class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3 A">
                <div class="row">
                    <div class="col">
                        <input type="search" name="title" class="form-control form-control-dark" placeholder="Search post...">
                    </div>
                    <div class="col">
                        <button type="submit" class="btn btn-outline-light">Search</button>
                    </div>
                </div>
            </form>

            <ul class="nav nav-pills">
                <li class="nav-item"><a href="/login" class="btn btn-success me-2">Sign-in</a></li>
                <li class="nav-item"><a href="/register" class="btn btn-warning">Sign-up</a></li>
                <li class="nav-item mx-2">
                    <form method="POST" action="/logout">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        <button class="btn btn-primary" type="submit">Logout</button>
                    </form>
                </li>
            </ul>
        </div>
    </div>
</header>