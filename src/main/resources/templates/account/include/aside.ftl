
<div class="bg-dark border rounded-3 text-white p-3" style="min-height: 78.7vh">
    <a href="/accounts/index" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-white text-decoration-none">
        <svg class="bi me-2" width="40" height="32">
            <use xlink:href="#bootstrap"></use>
        </svg>
        <span class="fs-4 text-center">Welcome: ${user.firstName}</span>
    </a>
    <hr>
    <ul class="nav nav-pills flex-column mb-auto">
        <li class="nav-item">
            <a href="/accounts/index" class="nav-link active">
                <svg class="bi me-2" width="16" height="16">
                    <use xlink:href="#home"></use>
                </svg>
                My posts
            </a>
        </li>
        <li class="mt-2">
            <a href="/accounts/data" class="nav-link nav-link active">
                <svg class="bi me-2" width="16" height="16">
                    <use xlink:href="#speedometer2"></use>
                </svg>
                My data
            </a>
        </li>

        <#if user.role == "ROLE_ADMIN">
            <li class="mt-2">
                <a href="/accounts/all" class="nav-link nav-link active">
                    <svg class="bi me-2" width="16" height="16">
                        <use xlink:href="#speedometer2"></use>
                    </svg>
                    All users
                </a>
            </li>
        </#if>

    </ul>
</div>