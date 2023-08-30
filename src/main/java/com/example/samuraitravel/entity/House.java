package com.example.samuraitravel.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

//クラスに@Entityアノテーションをつける
//@Entityはテーブルの1行をオブジェクトとして表現するためのクラス。
//@Tableアノテーションをつけ、対応づけるテーブル名を指定
//@Dataアノテーションをつけ、ゲッターやセッターなどを自動生成
//各フィールドに@Columnアノテーションをつけ、対応づけるカラム名を指定
//主キーには@Idおよび@GeneratedValueアノテーションをつける
@Entity
@Table(name = "houses")
@Data
public class House {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "image_name")
	private String imageName;

	@Column(name = "description")
	private String description;

	@Column(name = "price")
	private Integer price;

	@Column(name = "capacity")
	private Integer capacity;

	@Column(name = "postal_code")
	private String postalCode;

	@Column(name = "address")
	private String address;

	@Column(name = "phone_number")
	private String phoneNumber;

	@Column(name = "created_at", insertable = false, updatable = false)
	private Timestamp createdAt;

	@Column(name = "updated_at", insertable = false, updatable = false)
	private Timestamp updatedAt;
}