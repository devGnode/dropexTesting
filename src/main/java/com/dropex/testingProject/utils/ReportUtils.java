package com.dropex.testingProject.utils;

import io.qameta.allure.Attachment;

public final class ReportUtils {

    @Attachment(value="Json template",type="text/plain")
    public static String setJsonAllure(String json){
        return json;
    }
}
