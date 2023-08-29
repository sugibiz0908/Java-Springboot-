package com.example.samuraitravel.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.samuraitravel.entity.House;
import com.example.samuraitravel.repository.HouseRepository;

//①　クラスに@RequestMappingアノテーションをつけ、ルートパスの基準値を設定する

//②　コンストラクタで依存性の注入（DI）を行う（コンストラクタインジェクション）
//A（AdminHouseControllerクラス）がB（HouseRepositoryクラス）に依存しているということを表現しています。
//依存性の注入（DI）は、AがBのオブジェクトを外部から受け取る仕り、直接Bのオブジェクトを生成せずに利用するための手法です。
//アプリの起動時に@Controllerや@Service、@Componentなどのアノテーションがついたクラスのインスタンスを生成し、
//DIコンテナと呼ばれる領域にそれらのインスタンスを登録する仕組みがあります。

//③　HouseRepositoryインターフェースのfindAll()メソッドですべての民宿データを取得する

//④　Modelクラスを使ってビューにデータを渡す
@Controller
@RequestMapping("/admin/houses")
//②　AdminHouseControllerクラスがHouseRepositoryに依存している場合
//コンストラクタインジェクションを使う場合、
//上記のようにコンストラクタに@Autowiredアノテーションをつけます。
//ただし、今回のようにコンストラクタが1つしかない場合は以下のように省略が可能です。
//DIコンテナに登録されたインスタンスをコンストラクタなどに対して提供（注入）するのが@Autowiredアノテーションの役割です。
public class AdminHouseController {
    private final HouseRepository houseRepository;         
    
    public AdminHouseController(HouseRepository houseRepository) {
        this.houseRepository = houseRepository;                
    }	
//③
    @GetMapping
    public String index(Model model, Pageable pageable) {
    	Page<House> housePage = houseRepository.findAll(pageable);       
//④メソッド内でaddAttribute()メソッドを使い、以下の引数を渡す
//第1引数：ビュー側から参照する変数名　第2引数：ビューに渡すデータ
        model.addAttribute("houses", housePage);             
        
        return "admin/houses/index";
    }  
}
