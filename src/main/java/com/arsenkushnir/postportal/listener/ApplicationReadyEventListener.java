package com.arsenkushnir.postportal.listener;

import com.arsenkushnir.postportal.service.AdminUserInitializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ApplicationReadyEventListener implements ApplicationListener<ApplicationReadyEvent> {

    private final AdminUserInitializer adminUserInitializer;

    @Autowired
    public ApplicationReadyEventListener(AdminUserInitializer adminUserInitializer) {
        this.adminUserInitializer = adminUserInitializer;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        adminUserInitializer.createAdminIfNotExists();
    }
}
