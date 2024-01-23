const formulario = document.querySelector("form");
const mensagemElement = document.getElementById("mensagem");

const Inputnome = document.querySelector(".nome");
const Inputemail = document.querySelector(".email");
const Inputsenha = document.querySelector(".senha");
const Inputtel = document.querySelector(".tel");

function exibirMensagem(mensagem, cor) {
    mensagemElement.innerHTML = '';

    const paragrafo = document.createElement('p');
    paragrafo.textContent = mensagem;
    paragrafo.style.color = cor;

    mensagemElement.appendChild(paragrafo);
}

function validarCampos() {
    const camposPreenchidos = [Inputnome.value, Inputemail.value, Inputsenha.value, Inputtel.value];
    
    if (camposPreenchidos.some(valor => valor.trim() === '')) {
        exibirMensagem('Por favor, preencha todos os campos obrigatórios.', 'red');
        return false;
    }

    return true;
}

function cadastrar() {
    if (!validarCampos()) {
        return;
    }

    fetch("http://localhost:8080/usuarios", {
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
    .then(function(res) {
        if (res.ok) {
            exibirMensagem('Cadastro realizado com sucesso!', 'green');
        } else {
            exibirMensagem('Erro ao cadastrar. Por favor, tente novamente.', 'red');
        }
        return res.json();
    })
    .catch(function(error) {
        exibirMensagem('Erro ao cadastrar. Por favor, tente novamente.', 'red');
        console.log(error);
    });
}

function limpar() {
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
