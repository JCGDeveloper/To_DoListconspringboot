const inputText = document.getElementById('input-task');
const createTask = document.getElementById('create-button');
const ListaTareas = document.getElementById('Lista-Tareas');

createTask.addEventListener('click', AgregarTarea);

function validarUserId() {
    const userId = Number(sessionStorage.getItem("userId"));
    if (!userId || isNaN(userId) || userId <= 0) {
        alert("No hay una sesión válida. Por favor, inicie sesión.");
        window.location.href = "login.html";
        return null;
    }
    return userId;
}

function CargarTareas() {
    const userId = validarUserId();
    if (!userId) return;

    fetch(`http://localhost:8080/tasks/user/${userId}`)
        .then((response) => {
            if (!response.ok) {
                throw new Error("httpError " + response.status);
            }
            return response.json();
        })
        .then((tasks) => {
            ListaTareas.innerHTML = "";
            if (Array.isArray(tasks)) {
                tasks.forEach((task) => {
                    const li = document.createElement("li");
                    li.textContent = task.descripcion;
                    botonEliminar(li, task.id);
                    ListaTareas.appendChild(li);
                });
            }
        })
        .catch((error) => {
            console.error("Error al cargar las tareas:", error);
            if (error.message.includes("401") || error.message.includes("403")) {
                window.location.href = "login.html";
            }
        });
}

function AgregarTarea() {
    const userId = validarUserId();
    if (!userId) return;

    const descripcion = inputText.value.trim();
    if (!descripcion) {
        alert("La descripción de la tarea no puede estar vacía.");
        return;
    }

    const task = {
        descripcion: descripcion
    };

    fetch(`http://localhost:8080/tasks/${userId}`, {
        method: "POST",
        body: JSON.stringify(task),
        headers: {
            "Content-Type": "application/json",
        }
    }).then(response => {
        if (!response.ok) {
            throw new Error("HTTP error " + response.status);
        }
        return response.json();
    }).then(data => {
        console.log("Tarea creada:", data);
        CargarTareas();
    }).catch(error => {
        console.error("Error al crear la tarea:", error);
    });
}

function botonEliminar(li, taskId) {
    const botonEliminar = document.createElement('button');
    botonEliminar.textContent = "Eliminar Tarea";
    li.appendChild(botonEliminar);

    botonEliminar.addEventListener('click', () => {
        fetch(`http://localhost:8080/tasks/${taskId}`, {
            method: "DELETE",
            headers: {
                "Content-Type": "application/json",
            }
        })
        .then(response => {
            if (!response.ok) {
                throw new Error("HTTP error " + response.status);
            }
            li.remove();
            console.log("Tarea eliminada");
        })
        .catch(error => {
            console.error("Error al eliminar la tarea:", error);
        });
    });
}

CargarTareas();