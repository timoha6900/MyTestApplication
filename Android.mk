LOCAL_PATH := $(call my-dir)
include $(CLEAR_VARS)

LOCAL_RESOURCE_DIR := $(LOCAL_PATH)/app/src/main/res

LOCAL_MODULE_TAGS := optional
LOCAL_SDK_VERSION := current
LOCAL_PRIVILEGED_MODULE := true

LOCAL_PACKAGE_NAME := MyTestApplication

LOCAL_SRC_FILES := $(call all-java-files-under, app/src/main/java)

LOCAL_STATIC_ANDROID_LIBRARIES := \
        android-support-v4 \
        android-support-v7-appcompat \
	androidx-constraintlayout_constraintlayout \

LOCAL_USE_AAPT2 := true

include $(BUILD_PACKAGE)
