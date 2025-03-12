import requests
from flask import Blueprint, request, jsonify

employee_esb_routes = Blueprint('employee_esb_routes', __name__)

EMPLOYEE_SERVICE_URL = "http://localhost:5501"  # Change port if needed

@employee_esb_routes.route('/employees', methods=['GET'])
def get_all_employees():
    try:
        response = requests.get(f"{EMPLOYEE_SERVICE_URL}/employees")
        return jsonify(response.json()), response.status_code
    except Exception as e:
        return jsonify({"error": str(e)}), 500

@employee_esb_routes.route('/employees', methods=['POST'])
def create_employee():
    try:
        data = request.json
        response = requests.post(f"{EMPLOYEE_SERVICE_URL}/employees", json=data)
        return jsonify(response.json()), response.status_code
    except Exception as e:
        return jsonify({"error": str(e)}), 500
