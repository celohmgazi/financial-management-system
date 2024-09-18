: 'the goal for this is script is to:
    - compile an application
    - check the satisfaction of dependencies
    - run all tests
    - launch an application
    -  package an application for deployment
    '

compile_application() {
    echo "Compiling the aplication..."

    mvn clean compile

    if [ $? -ne 0 ]; then
        echo "Compilation error"
        exit 1
    fi
}

check_dependencies() {
    echo "Checking dependencies..."

    mvn dependency:resolve

    if [ $? -ne 0 ]; then
        echo "Compilation error"
        exit 1
    fi
}

run_tests() {
    echo "Running tests..."

    mvn test

    if [ $? -ne 0 ]; then
        echo "Some tests are failing!"
        exit 1
    
    fi
}

start_server() {
    echo "Starting the server..."
    java -jar target/financial-management-system-1.0-SNAPSHOT-jar-with-dependencies.jar&
    SERVER_PID=$!
    sleep 5
}


stop_server() {
    echo "Stopping the server..."
    if [ -n "$SERVER_PID" ]; then
        kill $SERVER_PID
    fi
}


package_app() {
    echo "Packaging the application..."
   
    mvn package -DskipTests
    if [ $? -ne 0 ]; then
        echo "Packaging failed!"
        exit 1
    fi
}

# Main script logic
echo "Starting build process..."

compile_application
check_dependencies
package_app
start_server
run_tests
stop_server

echo "Build process completed successfully!"