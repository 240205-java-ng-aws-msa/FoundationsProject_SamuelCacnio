async function login(){
    const url = "http://localhost:8080/login"

    const logInfo = {
        email: document.getElementById("email-input").value,
        password: document.getElementById("pass-input").value
    };

    const warning = document.getElementById("warning");

    try{
        const res = await fetch(url, {
            method: "POST",
            headers: {
            "Content-Type": "application/json",
            },
            body: JSON.stringify(logInfo)
            }
        );
        if (res.status === 200){
            const data = await res.json();

            const accountInfo = document.getElementById("account");
            while (accountInfo.firstChild){
                accountInfo.lastChild.remove();
            }
            const logName = document.createTextNode("Logged in as: "+data.email);
            accountInfo.appendChild(logName);

            cartCount(data.accountId);
            
            const logOut = document.createElement("input");
            logOut.type = "button";
            logOut.value = "Logout";
            logOut.setAttribute("onclick", "logout()");
            accountInfo.appendChild(logOut);

        }
        else if (res.status === 401){
            warning.innerHTML = "Invalid credentials. Try again.";
            document.getElementById("email-input").value = "";
            document.getElementById("pass-input").value = "";
        }
        else{
            warning.innerHTML = "Something went wrong. Please try again.";
            document.getElementById("email-input").value = "";
            document.getElementById("pass-input").value = "";
        }
    }
    catch (err){
        window.location.reload();;
    }
}

function logout(){
    window.location.reload();
}

async function register(){
    const url = "http://localhost:8080/register"

    const logInfo = {
        email: document.getElementById("email-input").value,
        password: document.getElementById("pass-input").value
    };
    const warning = document.getElementById("warning");
    if (logInfo.password.length < 8){
        warning.innerHTML = "Password must be at least 8 characters."
        document.getElementById("pass-input").value = "";
        return;
    }
    try{
        const res = await fetch(url, {
            method: "POST",
            headers: {
            "Content-Type": "application/json",
            },
            body: JSON.stringify(logInfo)
            }
        );
        if (res.status === 200){
            const data = await res.json();
            
            const accountInfo = document.getElementById("account");
            while (accountInfo.firstChild){
                accountInfo.lastChild.remove();
            }
            const logName = document.createTextNode("Welcome new user: "+data.email);
            accountInfo.appendChild(logName);

            cartCount(data.accountId);
            
            const logOut = document.createElement("input");
            logOut.type = "button";
            logOut.value = "Logout";
            logOut.setAttribute("onclick", "logout()");
            accountInfo.appendChild(logOut);
        }
        else if (res.status === 400){
            warning.innerHTML = "Account already exits. Try Login.";
        }
        else{
            warning.innerHTML = "Something went wrong. Please try again.";
            document.getElementById("email-input").value = "";
            document.getElementById("pass-input").value = "";
        }
    }
    catch (err){
        window.location.reload();;
    }
}

async function cartCount(accountId){
    const url = "http://localhost:8080/users/"+accountId.toString()+"/count";
    try{
        const res = await fetch(url);
        if (res.status === 200){
            const data = await res.json();
            const accountInfo = document.getElementById("account");
            const count = document.createTextNode(data);
            accountInfo.appendChild(count);
        }
        else{
            console.log("fail");
        }
    }
    catch (err){
        console.log(err);
    }
}