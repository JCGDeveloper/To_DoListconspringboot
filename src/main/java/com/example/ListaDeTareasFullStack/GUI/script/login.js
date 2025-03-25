let username = document.getElementById('txtusername');
let password = document.getElementById('txtpassword');
let botonLogin = document.getElementById('buton-login');
async function loginUser() {
    const usuario = {
        username: username.value,
        password: password.value
    };
    try {
        const response = await fetch("http://localhost:8080/api/login", {
            headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        method: "POST",
        body: JSON.stringify(usuario)
        });

        if (response.ok) {
            const data = await response.json(); // Asegúrate de que el id del usuario sea parte de la respuesta
            alert("Login exitoso");

            sessionStorage.setItem("userId", data.id);

            window.location.href = "index.html";
        } else {
            alert("Credenciales incorrectas.");
        }
    } catch (error) {
        console.error("Error en la solicitud:", error);
        alert("Hubo un problema al conectar con el servidor.");
    }
}


botonLogin.addEventListener('click', loginUser);