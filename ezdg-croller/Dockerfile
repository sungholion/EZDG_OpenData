FROM python:3.12.7

# 필수 라이브러리 설치
RUN apt update && apt install -y wget unzip libxpm4 libxrender1 libgtk2.0-0 libnss3 libgconf-2-4 fonts-liberation

# Chrome 설치
RUN wget https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb \
    && apt install -y ./google-chrome-stable_current_amd64.deb

# ChromeDriver 설치
RUN wget -O /tmp/chromedriver.zip https://chromedriver.storage.googleapis.com/130.0.6723.116/chromedriver_linux64.zip \
    && unzip /tmp/chromedriver.zip -d /usr/local/bin/

# 작업 디렉토리 설정
WORKDIR /app

# 필요한 패키지 설치
COPY requirements.txt .
RUN pip install --no-cache-dir -r requirements.txt

# 애플리케이션 코드 복사
COPY . .

# uvicorn을 통해 FastAPI 앱 실행
CMD ["uvicorn", "Server:app", "--host", "0.0.0.0", "--port", "8000"]
