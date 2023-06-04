# java_spring_boot_mayaa_formatnumber_cannot_convert

## 概要
- Spring Boot + Mayaa 環境で発生したエラーの調査

## 事象
- Mayaa の m:formatNumber タグで value にフォームのプロパティ( 例：```value="${helloForm.fff}"``` )を指定すると実行時に Cannot convert エラーが発生する。
![](doc/img/2023-06-03%20034506.png)

## 前提
- Spring Boot で テンプレートエンジンに Mayaa を使用
- 出力は war ファイル
- 実行は Spring Boot 内臓の Tomcat は使わず Community Server Connector を使用

## 詳細
※関係する行のみ抜粋

HelloForm.java
```java
@Data
public class HelloForm {
    private String fff = "6789";
}
```

HelloController.java
```java
@Controller
public class HelloController {
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("helloForm", new HelloForm());
        return "hello";
    }
}
```

hello.mayaa
```xml
<?xml version="1.0" encoding="UTF-8"?>
<m:mayaa xmlns:m="http://mayaa.seasar.org">
    <m:formatNumber m:id="fff" value="${helloForm.fff}" pattern="#,###" />
</m:mayaa>
```

hello.html
```html
<html>

<body>
    <span id="fff" /><br>
</body>

</html>
```

## メモ
### 発生バージョン
結論：バージョン関係ない
|  バージョン  |  発生有無  |  備考  |
| ---- | ---- | ---- |
|  1.2  |  ❌発生する  |    |
|  1.1.34  |  ❌発生する  |    |
|  1.1.33  |  ❌発生する  |    |
|  1.1.32  |  ❌発生する  |    |
|  1.1.31  |  ❌発生する  |    |
|  1.1.30  |  ❌発生する  |    |
|  1.1.29  |  ❌発生する  |    |
|  1.1.28  |  ❌発生する  |  起動時に SAXParseException: Premature end of file.  |
|  1.1.18  |  ❌発生する  |  起動時に SAXParseException: Premature end of file.  |

## 参考
- java_spring_boot_mayaa_example1  
  https://github.com/Tobotobo/java_spring_boot_mayaa_example1
