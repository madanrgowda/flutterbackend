package com.app.backend.Response;



import lombok.Data;

@Data
public class Reponsestructure<T> {
int code;
	String messgae;
	T data;
}
