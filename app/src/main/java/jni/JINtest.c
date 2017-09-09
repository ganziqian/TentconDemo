//
// Created by Administrator on 2017/8/5.
//
#include "com_zwg_tentcondemo_utils_NDKtest.h"
JNIEXPORT jstring JNICALL Java_com_zwg_tentcondemo_utils_NDKtest_getJNIString
  (JNIEnv * env, jclass jclass){
	return (*env)->NewStringUTF(env, "C string");
     };