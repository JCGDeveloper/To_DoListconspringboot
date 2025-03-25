let username = document.getElementById('txtusername');
let password = document.getElementById('txtpassword');
let botonLogin = document.getElementById('buton-login');
botonLogin.addEventListener('click', registrarUser);

async function registrarUser() {
    // Validar que los campos no estén vacíos
    if (!username.value || !password.value) {
        alert("Por favor, completa todos los campos.");
        return;
    }

    const usuario = {}
    usuario.username = username.value
    usuario.password = password.value

    try {
        const response = await fetch("http://localhost:8080/users", {
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            method: "POST",
            body: JSON.stringify(usuario)
        });

        if (response.ok) {
            alert("Todo correcto");
            location.reload();
        } else {
            alert("Error al registrar el usuario.");
        }
    } catch (error) {
        console.error("Error en la solicitud:", error);
        alert("Hubo un problema al conectar con el servidor.");
    }
}
