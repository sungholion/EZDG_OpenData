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

## 관리자 페이지

### API 등록 및 공공데이터 포털 크롤링
![api-등록-크롤링](/uploads/b02007ecd0a87f72a7a354d4ff31cd91/api-등록-크롤링.gif)

### API 크롤링 결과 확인 및 저장
![api-등록-결과-저장](/uploads/ec2da23a41af49a58af37b9e4f9660f9/api-등록-결과-저장.gif)

### 파일 등록 
![파일-등록-업로드](/uploads/477c1848b35249e5096d3a99de45d1af/파일-등록-업로드.gif)

### 파일 컬럼명 번역
![파일-등록-번역](/uploads/8c690c44b1f6b12b9e9d498f6a3796a5/파일-등록-번역.gif)

### 라이브러리 배포
![파일-배포-현황](/uploads/e1c7edcb48f2ec1b9b99759c40904b9b/파일-배포-현황.gif)
