# Name
SpringBoot,SpringSecurityを使用したFormログインのサンプル

# Requiment
PostgreSQL:10.15-1
OpenJDK:14.0.1
Eclipse:pleiades-2020-12-java-win-64bit_20201101

# Structure
Spring Initializer

Project:Gradle Project
Java:15
Spring boot:2.4.2

Group:ccs.education
Artiface:login
Name:login
Description:Demo project for Spring Security
Package name:ccs.education.login
Packaging:Jar

Depedencies:
Spring Web
PostgreSQL Driver
Spring Security
Spring Data JPA

# Usage
設定の流れ

1.テーブルの作成用の設定

    1-1.\login\sql\run.batの接続先情報を環境に合わせて設定する

    1-2.\login\sql\run.batを実行する
    →自動でdbを作成するので[normal end.]が出ていればok

2.eclipseからworkspaceを開く

    2-1.C:\pleiades\eclipse\eclipse.exeを実行する
    →eclipseを起動する

    2-2.workspaceの指定が出るので、\Java_DevAdv2Auth_Login\workspace\を指定する
    →eclipseが起動すること

    ※workspaceの選択が起動時に出ない場合は、eclipseのメニューから
    ファイル→ワークスペースの切り替え→その他で選択を行うこと

3.gradleのインポートを行う

    3-1.ファイル→インポート→Gradle→既存のGradleプロジェクトを選択し次へを押下
    →プロジェクトのインポート画面が開くこと

    3-2.参照からC:\education\03.eclipse_workspaces\Java_DevAdv2Auth_Login\workspace\loginを選択し完了を押下
    →プロジェクトがインポートされ、パッケージエクスプローラにloginが表示されること

    3-3.application.propertiesの接続先情報を環境に合わせて設定する
    →接続先情報があっていない場合、4-2で起動時に失敗する。

4.プロジェクトのビルド

    4-1.Gradleタスクからlogin→build→bootjarを右クリックしGradleタスクの実行を選択
    →演算命令がすべて青丸になっていること

    4-2.パッケージエクスプローラのlogin上で右クリックし、実行→Spring bootアプリケーションを選択
    コンソールでERRORが出ずにStarted LoginApplicationが出ること

5.初期画面の表示

    5-1.http://localhost:8080/をブラウザのアドレスに入力
    →「Top」が表示されること

# Note

DB,テーブルの構成
```
CREATE DATABASE logindb;
CREATE EXTENSION pgcrypto;
CREATE TABLE account (

id VARCHAR(20) NOT NULL
, password TEXT
, PRIMARY KEY(id)
, UNIQUE (id));
```

URLの構成
```
トップ画面(Topと表示されるだけ、制御なし)
http:localhost:8080/

ログイン画面(SpringSecurityの標準ログイン画面)
http:localhost:8080/login

ログイン成功画面(ログイン成功画面、制御あり)
http:localhost:8080/success

Hello画面(Helloと表示されるだけ、制御なし(変更可))
http:localhost:8080/hello
```

# Author
# Licence

# Reference
参考にさせて頂いたサイト

[PostgreSQLのUUID型とpgcryptoモジュールを使って会員パスワード認証を実装してみる](https://www.techscore.com/blog/2016/02/04/postgresql%E3%81%AEuuid%E5%9E%8B%E3%81%A8pgcrypto%E3%83%A2%E3%82%B8%E3%83%A5%E3%83%BC%E3%83%AB%E3%82%92%E4%BD%BF%E3%81%A3%E3%81%A6%E4%BC%9A%E5%93%A1%E3%83%91%E3%82%B9%E3%83%AF%E3%83%BC%E3%83%89/)

[最初のSpring Security - フォーム認証＆画面遷移](https://qiita.com/huge-book-storage/items/56b86d2986cf04632706)

[Spring Boot + PostgreSQLの設定方法](https://qiita.com/k0uhashi/items/55cbb88fd0d1b8ae4721)

[Spring Data JPA SQLログ出力](https://qiita.com/thankkingdom/items/de5e74e3615818c65f1d)

[Spring Data JPA：Repositoryの@QueryにpureなSQLでクエリを記述する](https://qiita.com/rennnosuke/items/2d3a06ac5a755c656d4b)

[Spring Bootで、ユーザ名とパスワードを指定した認証処理の実装方法](https://qiita.com/pale2f/items/3fb28e76f969d7c18f06)

[Spring Data JPA @Query](https://www.codeflow.site/ja/article/spring-data-jpa-query)

[SpringSecurityでユーザー認証機能を簡単につくる](https://qiita.com/aikumi/items/256b7892effd5c92a39f)

[Spring BootでWebセキュリティを設定しよう](https://codezine.jp/article/detail/11703)
