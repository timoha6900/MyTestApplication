LOCAL_PATH := $(call my-dir)
include $(CLEAR_VARS)

LOCAL_SRC_FILES := $(call all-java-files-under, app/src/main/java)
LOCAL_RESOURCE_DIR := $(LOCAL_PATH)/app/src/main/res
LOCAL_MANIFEST_FILE := app/src/main/AndroidManifest.xml

LOCAL_MODULE_TAGS := optional
LOCAL_PRIVILEGED_MODULE := true
LOCAL_CERTIFICATE = platform
LOCAL_PRIVATE_PLATFORM_APIS := true

LOCAL_PACKAGE_NAME := MyTestApp

LOCAL_STATIC_JAVA_LIBRARIES += android.hardware.vibrator-V1.3-java \
	android.hidl.base-V1.0-java

LOCAL_STATIC_ANDROID_LIBRARIES := \
        android-support-v4 \
        android-support-v7-appcompat \
	androidx-constraintlayout_constraintlayout \

LOCAL_USE_AAPT2 := true

include $(BUILD_PACKAGE)
