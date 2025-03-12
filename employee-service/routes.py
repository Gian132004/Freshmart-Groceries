import requests
from flask import Blueprint, request, jsonify
from config import Config

employee_routes = Blueprint('employee_routes', __name__)
ESB_URL = Config.ESB_URL

@employee_routes.route('/employees', methods=['GET'])
def get_all_employees():
    try:
        response = requests.get(f"{ESB_URL}/employees")
        return jsonify(response.json()), response.status_code
    except Exception as e:
        return jsonify({"error": str(e)}), 500

@employee_routes.route('/employees', methods=['POST'])
def create_employee():
    try:
        data = request.json
        response = requests.post(f"{ESB_URL}/employees", json=data)
        return jsonify(response.json()), response.status_code
    except Exception as e:
        return jsonify({"error": str(e)}), 500
