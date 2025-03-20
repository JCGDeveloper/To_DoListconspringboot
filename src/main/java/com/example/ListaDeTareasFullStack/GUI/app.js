const inputText = document.getElementById('input-task')
const createTask = document.getElementById('create-button')
const ListaTareas = document.getElementById('Lista-Tareas')

createTask.addEventListener('click',AgregarTarea)

function CargarTareas() {
    fetch("http://localhost:8080/tasks")
        .then((response) => {
            if (!response.ok) {
                throw new Error("httpError " + response.status);
            }
            return response.json();
        })
        .then((tasks) => {
            // Limpiar la lista antes de agregar nuevas tareas
            ListaTareas.innerHTML = "";

            // Iterar sobre las tareas y agregarlas como elementos <li>
            tasks.forEach((task) => {
                const li = document.createElement("li");
                li.textContent = task.descripcion; // Mostrar la descripción de la tarea
                botonEliminar(li,task.id); // Agregar botón para eliminar la tarea
                ListaTareas.appendChild(li);
            });
        })
        .catch((error) => {
            console.error("Error al cargar las tareas:", error);
        });
}

function AgregarTarea() {
    const task = {
        descripcion: inputText.value
    };

    fetch('http://localhost:8080/tasks', {
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