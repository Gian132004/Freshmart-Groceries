import os

class Config:
    # MongoDB URI
    MONGO_URI = os.getenv('MONGO_URI', 'mongodb://localhost:27017/employees')
    
    # ESB URL
    ESB_URL = os.getenv('ESB_URL', 'http://localhost:5501')  # Adjust port if needed
