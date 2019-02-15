package com.example.demo.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class DanWei implements Serializable {
	private int id;
	private String mingCheng;
	private String treeID;
	private String pID;
	private int quanXian;
	private int sID;
}