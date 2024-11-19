import logging


from fastapi import FastAPI, HTTPException, Request
from pydantic import BaseModel
from fastapi.responses import JSONResponse
import Croller

app = FastAPI()

# 로그
logging.basicConfig(
    level = logging.INFO,
    format = "%(asctime)s - %(name)s - %(levelname)s - %(message)s",
    handlers=[
        logging.FileHandler("app.log"),
        logging.StreamHandler()
    ]
)
logger = logging.getLogger(__name__)
print("server start")

class ApiCrollRequest(BaseModel):
    url: str

@app.post("/table")
def crollTableFormApi(request_data: ApiCrollRequest):
    url = request_data.url
    if not url:
        raise HTTPException(status_code=400, detail="Text not provided")
    print(url)
    return Croller.main_crawler(url)

@app.post("/swagger")
def swaggerFormApi(request_data: ApiCrollRequest):
    url = request_data.url
    if not url:
        raise HTTPException(status_code=400, detail="Text not provided")
    print(url)
    return Croller.swagger_crawler(url)

if __name__ == "__main__":
    import uvicorn
    uvicorn.run(app, host="192.168.100.149", port=8000)