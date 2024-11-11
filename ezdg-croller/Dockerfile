FROM python:3.12.7

# 필수 라이브러리 설치
RUN apt update && apt install -y wget unzip libxpm4 libxrender1 libgtk2.0-0 libnss3 libgconf-2-4 fonts-liberation

# Chrome 설치
RUN wget https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb \
    && apt install -y ./google-chrome-stable_current_amd64.deb \
    && rm ./google-chrome-stable_current_amd64.deb  # 설치 후 .deb 파일 제거

# ChromeDriver 버전을 Chrome 버전과 일치시키기 위한 설정
# ChromeDriver 버전 자동 설정 (Chrome 130 버전에 맞는 최신 버전 가져오기)
RUN CHROME_DRIVER_VERSION=$(curl -sS https://chromedriver.storage.googleapis.com/LATEST_RELEASE_130) && \
    wget -O /tmp/chromedriver.zip https://chromedriver.storage.googleapis.com/$CHROME_DRIVER_VERSION/chromedriver_linux64.zip && \
    unzip /tmp/chromedriver.zip -d /usr/local/bin/ && \
    rm /tmp/chromedriver.zip  # 설치 후 .zip 파일 제거

# 환경 설정
ENV DISPLAY=:99

# 작업 디렉토리 설정
WORKDIR /app

# 필요한 패키지 설치
COPY requirements.txt .
RUN pip install --no-cache-dir -r requirements.txt

# 애플리케이션 코드 복사
COPY . .

# uvicorn을 통해 FastAPI 앱 실행
CMD ["uvicorn", "Server:app", "--host", "0.0.0.0", "--port", "8000"]
