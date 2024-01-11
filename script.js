const formulario = document.querySelector("form");

const Inputnome = document.querySelector(".nome");
const Inputemail = document.querySelector(".email");
const Inputsenha = document.querySelector(".senha");
const Inputtel = document.querySelector(".tel");

function cadastrar() {

    fetch("https://localhost:8080/cadastrar", 
    {
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        method: "POST",
        body: JSON.stringify({
            nome: Inputnome.value,
            email: Inputemail.value,
            senha: Inputsenha.value,
            telefone: Inputtel.value
        })
    })
    .then(function(res){ console.log(res) })
    .catch(function(res){ console.log(res) })
    
};

function limpar () {
     Inputnome.value = "";
     Inputemail.value = "";
     Inputsenha.value = "";
     Inputtel.value = "";
}

formulario.addEventListener('submit', function (event) {
    event.preventDefault();

    cadastrar();
    limpar();
});
