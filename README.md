<h3>SSAFY 11기 2학기 자율 프로젝트</h3>
![image](/uploads/a599f2681a5cffea8a242278a4e31d5e/image.png)
</br>

<div align="center">
<![image](/uploads/a599f2681a5cffea8a242278a4e31d5e/image.png)" style="width:300px ">
</div>



# 팀원 소개

<div align="center">

| <img src="https://github.com/dlguswls456.png" width="100"/> | <img src="https://github.com/ansehdwls.png" width="100"/> | <img src="https://github.com/suwhan2.png" width="100"/> | <img src="https://github.com/sungholion.png" width="100"/> | <img src="https://github.com/CHASANGGON.png" width="100"/> | <img src="https://github.com/SnowySparks.png" width="100"/> |
|:---------------------------------------------------------:|:-------------------------------------------------------:|:----------------------------------------------------------:|:---------------------------------------------------------:|:---------------------------------------------------------:|:---------------------------------------------------------:|
|       [박형준 - BE, Infra](https://github.com/dlguswls456)       |       [박태우 - MB](https://github.com/ansehdwls)       |       [박경모 - BE](https://github.com/suwhan2)       |       [조성호 - BE](https://github.com/sungholion)       |       [하재훈 - FE](https://github.com/CHASANGGON)       |       [박민규 - FE](https://github.com/SnowySparks)       |

[팀노션](https://purple-okapi-e46.notion.site/11f17534f9e5806eabf7e5fe5a78b213?pvs=4) |
| [개발 일지](https://worried-venom-487.notion.site/60fd1b1753314e9d89537ea47528ae4e)

</div>




<center>
<h1>Tech Stack</h1>

### BackEnd

<img src="https://img.shields.io/badge/JAVA-FBBA00?logoColor=000&style=for-the-badge"> 
<img src="https://img.shields.io/badge/Spring%20Boot-6DB33F?logo=springboot&logoColor=fff&style=for-the-badge">
<img src="https://img.shields.io/badge/MySQL-4479A1?logo=mysql&logoColor=fff&style=for-the-badge"> <img src="https://img.shields.io/badge/MongoDB-47A248?logo=mongodb&logoColor=fff&style=for-the-badge">
<img src="https://img.shields.io/badge/Redis-FF4438?logoColor=fff&style=for-the-badge">
<img src="https://img.shields.io/badge/Jmeter-D22128?logoColor=fff&style=for-the-badge">


### FrontEnd

<img src="https://img.shields.io/badge/HTML5-E34F26?style=for-the-badge&logo=HTML5&logoColor=white"> <img src="https://img.shields.io/badge/CSS3-1572B6?style=for-the-badge&logo=CSS3&logoColor=white">
<img src="https://img.shields.io/badge/JavaScript-F7DF1E?style=for-the-badge&logo=JavaScript&logoColor=white">
<img src="https://img.shields.io/badge/React-61DAFB?style=for-the-badge&logo=React&logoColor=white">
<img src="https://img.shields.io/badge/React_Router-CA4245?style=for-the-badge&logo=react-router&logoColor=white">
<img src="https://img.shields.io/badge/vite-%23646CFF.svg?style=for-the-badge&logo=vite&logoColor=white">





### CI/CD

<img src="https://img.shields.io/badge/Docker-2496ED?logo=docker&logoColor=fff&style=for-the-badge"> <img src="https://img.shields.io/badge/Jenkins-D24939?logo=jenkins&logoColor=fff&style=for-the-badge">
<img src="https://img.shields.io/badge/Amazon%20EC2-F90?logo=amazonec2&logoColor=fff&style=for-the-badge">
<img src="https://img.shields.io/badge/NGINX-009639?logo=nginx&logoColor=fff&style=for-the-badge">

### Team Collaboration Tools

<img src="https://img.shields.io/badge/Jira-0052CC?logo=jira&logoColor=fff&style=for-the-badge"> <img src="https://img.shields.io/badge/GitLab-FC6D26?logo=gitlab&logoColor=fff&style=for-the-badge">
<img src="https://img.shields.io/badge/Mattermost-0058CC?logo=mattermost&logoColor=fff&style=for-the-badge">
<img src="https://img.shields.io/badge/Discord-5865F2?logo=discord&logoColor=fff&style=for-the-badge">
<img src="https://img.shields.io/badge/Notion-000?logo=notion&logoColor=fff&style=for-the-badge">
</center>

</br>
</br>
<h1>Architecture</h1>
![image](/uploads/7bba05073e56303f04d0d46d997df3ab/image.png)

# 소개

### 🌃 기획 의도

> 공공 데이터를 쉽게 사용할 수 없을까?

- 공공데이터를 활용한 서비스가 증가하고 있음.
- 개발이 익숙하지 않은 사람은 공공 데이터 활용을 위한 코드 작성이 어려움.
- 개발자는 파일 데이터와 Open API를 사용하기 위해 호출 코드를 반복 작성해야 함.
- 간편하게 공공 데이터 포털이 제공하는 데이터를 가져올 수 있게 돕는 라이브러리를 기획하게 되었음.

### 서비스 대상

- 개발이 익숙하지 않은 사람
- 개발이 능숙하지만, 공공 데이터 조회를 위해 반복해서 코드 작 번거로운 사람

이러한 사람들을 타겟으로 잡아두었습니다.

### 💎 서비스 기능

공통

- 메인 화면에서 올라온 여러 투어 관련 글 볼 수 있음
- 각 투어 글마다 리뷰 확인 가능
- 특정 조건 달성 시 스탬프를 획득하는 재미 요소

가이트(현지인) 입장

- 가이드는 생각해 둔 투어 일정에 대한 글 작성
- 관광객과 1:1 채팅이 가능하고, 채팅을 통해 협의되었을 경우 예약 가능
- 둘이 만났을 경우에 QR체크를 통해 확인이 가능

관광객(특히 외국인 관광객) 입장

- 관심 있어 하는 투어글에 대해 위시리시트에 담을 수 있음
- 해당 투어에 대해 가이드랑 1:1 채팅이 가능하고, 번역이 가능

# 🎇 서비스 이용 화면

## 가이드 페이지 

### 메인 페이지 
![EZDG_-_Chrome_2024-11-18_20-43-48](/uploads/eded36693883f0fa9b1472e49af7ceef/EZDG_-_Chrome_2024-11-18_20-43-48.gif)
### 검색 기능
![EZDG_-_Chrome_2024-11-18_20-44-52](/uploads/4f5713af43feb223a2e0ef6ccf12880c/EZDG_-_Chrome_2024-11-18_20-44-52.gif)
### 설치 가이드 
![EZDG_-_Chrome_2024-11-18_20-45-09__1_](/uploads/73189ed9d80bbdf5ac52807829ce34c5/EZDG_-_Chrome_2024-11-18_20-45-09__1_.gif)

## 예시프로젝트 - 대구의 자랑
![대구의_자랑_-_Chrome_2024-11-18_14-49-00](/uploads/f80384aecaa80ffb7851edb91d55d59a/대구의_자랑_-_Chrome_2024-11-18_14-49-00.gif)

## 예시프로젝트 - Find My Company!
![기업_기본_정보_조회_-_Chrome_2024-11-18_14-25-12](/uploads/374606ad619279dace61abe1224c9944/기업_기본_정보_조회_-_Chrome_2024-11-18_14-25-12.gif)

## 회원가입 & 로그인

### 로그인

첫 화면

<center>
<img src="./READMEimg/login.jpg" style="width:200px">
</center>

### 회원가입

<center>
회원가입 절차 모습

<img src="./READMEimg/signin1.jpg" style="width:200px"> <img src="./READMEimg/signin2.jpg" style="width:200px"> <img src="./READMEimg/signin3.jpg" style="width:200px">

<br>
<br>

</center>
<center>
이메일 인증 코드 번호

<img src="./READMEimg/verify.png" style="width:200px">
</center>

## 기능

본 화면은 "가이드" 계정을 로그인 했을 경우와 여행객 계정을 로그인 했을 때 각각 다른 기능을 지원함

<center>

| 메인화면 | 프로필 사진 |
| -------- | ----------- |

| <img src="./READMEimg/NavMain.jpg" style="width:200px"> | <img src="./READMEimg/Profile.jpg" style="width:200px"> |

왼쪽은 여행객이 로그인 했을 때 , 오른쪽은 가이드 계정 로그인 했을 때  
각각 마다 밑에 NavigationBar가 다름

</center>

### 가이드(Navs)

<center>
<h4>투어 작성</h4>

<img src="./READMEimg/TourCreate.gif">

<h4>예약 작성</h4>

<img src="./READMEimg/ReservationMake2.jpg" style="width:200px"> <img src="./READMEimg/ReservationMake3.jpg" style="width:200px">

</center>

### 여행객 (Tour)

<center>

<h4>위시리스트</h4>
<img src="./READMEimg/Main_Wish.jpg" style="width:200px"> <img src="./READMEimg/WishList.jpg" style="width:200px">

<h4> 완료한 투어 목록 및 예약 리스트 </h4>

</center>

### 채팅 (공통)

<center>

채팅 방 목록

<img src="./READMEimg/Chat.jpg" style="width:200px">

영어에서 한국어로 번역이 가능하도록 기능 지원  
해당 채팅칸에 터치를 하면 작동하며 다시 터치하면 원래대로 돌아감

<img src="./READMEimg/Chat_Translation.png" style="width:600px">

가이드(Navs) 입장에선 해당 채팅방에 "예약" 버튼이 활성화가 됨

<img src="./READMEimg/ReservationMake1.jpg" style="width:200px">

</center>

### 투어 상세 글

<center>

<h4>상세 글</h4>  
<img src="./READMEimg/tour_detail1.jpg" style="width:200px">   <img src="./READMEimg/tour_detail2.jpg" style="width:200px"> <img src="./READMEimg/tour_detail_review.jpg" style="width:200px">

<br>
<br>

가이드(Navs) 입장에선 하단 버튼에서 **예약 현황**으로 바뀜

<img src="./READMEimg/tour_detail_nav.jpg" style="width:200px">

<br>
<br>

**Plan(계획) 아이템들을 클릭하면 뜨는 모습**

<img src="./READMEimg/plan_image.jpg" style="width:200px">

<h4>리뷰</h4>
(View All Reviews > 버튼을 누르면 들어가짐)

<img src="./READMEimg/review_detail.jpg" style="width:200px">

**리뷰 포토들 목록**

<img src="./READMEimg/review_photo1.jpg" style="width:200px"> <img src="./READMEimg/review_photo2.jpg" style="width:200px">

</center>

### 예약 리스트(관광객전용) & 예약 상세(공통)

<center>
<img src="./READMEimg/ResList.jpg" style="width:200px"> <img src="./READMEimg/ResDetail.jpg" style="width:200px">

각각 예약 목록들(투어 관광객에 보여주는 것)

</center>

### 나의 투어 작성 목록 및 예약 현황 (가이드 전용)

<center>
<img src="./READMEimg/myTourList.jpg" style="width:200px"> <img src="./READMEimg/tourResList.jpg" style="width:200px"  >

가이드 입장에서 본인이 작성한 투어글들 볼 수 있고  
해당 글들에 대해서 예약 목록을 볼 수 있음

(예약 목록 보는 방법은, 투어 상세 페이지로 들어가야 볼 수 있음)

</center>

### QR

<center>

<img src="./READMEimg/QRButton.jpg" style="width:200px">

예약 상세에보기에서 만남 날짜 때 QR 버튼이 나타남

<img src="./READMEimg/Screenshot_20240815_164413_NativeNavs.jpg" style="width:200px">

관광객 입장에선 QR이 보이고, 가이드 입장에서 카메라가 열리는 구조로 되어 있음
가이드가 관광객 QR를 찍음으로써 만났다는 인증이 되는 방식

</center>

## 알림

<center>

예약이 완료되었는 등의 이벤트 가 발생하면 알림이 발생함

<img src="./READMEimg/alarm.jpg" style="width:300px" >

</center>

## 스탬프

<center>

<img src="./READMEimg/stamp_detail.jpg" style="width:200px"> <img src="./READMEimg/profile_stamp.jpg" style="width:200px">

</center>

# 🔨 사용한 기술

## 예시 서비스2 Dague Travel - 조회 성능 개선

- Aggregation
- Redis
- Batch

<img src ="./READMEimg/HybridApp.png" style="width:200px">

## FCM 활용한 푸쉬 알림 기능

<img src="./READMEimg/FCM.png" style="width:400px">

## WebSocket & STOMP

### WebSocket

웹 소켓을 활용하여 실시간 채팅을 활용함 - 채팅방에서 유용하게 사용함

### STOMP

웹 소켓 위에서 동작하는 메시징 프로토콜이며  
텍스트 기반 간단한 명령여를 사용하여 - 클라이언트 과 서버 간 메세지 교환이 손쉽게 이루어 질 수 있음

<img src ="./READMEimg/STOMP.png" style="width:200px">

## QR

zxing 라이브러리를 활용하여 QR를 생성함  
스캔 후 모바일에 저장된 유저 토큰을 활용하셔 인증 처리 및 스탬프를 발급

