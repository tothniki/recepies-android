package com.example.nikolettatoth.recepies_andoid.di;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;
import javax.inject.Qualifier;

@Qualifier
@Retention(RUNTIME) // not needed
public @interface Network {
}