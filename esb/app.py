from flask import Flask
from routes.employee_route import employee_esb_routes

app = Flask(__name__)

# Register routes
app.register_blueprint(employee_esb_routes)

if __name__ == '__main__':
    app.run(port=5500, debug=True)  # ESB runs on port 5500
