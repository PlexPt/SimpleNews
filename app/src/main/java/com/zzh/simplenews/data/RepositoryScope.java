package com.zzh.simplenews.data;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by zzh on 16/6/9.
 */
@Documented
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface RepositoryScope {

}
