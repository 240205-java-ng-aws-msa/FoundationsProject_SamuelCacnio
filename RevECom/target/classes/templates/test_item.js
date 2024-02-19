async function test_item(){ 
    const url = "http://localhost:8080/store/";

    try{
        console.log("fetching");
        const res = await fetch(url);
        console.log(res.status);
        if (res.status === 200){
            const data = await res.json();
            data = data.getItem(0);
            
            const shop = document.getElementById("shop-display");
            const item = document.createElement("div");

            const item_name = document.createElement("p");
            console.log(data.name);
            item_name.innerHTML = data.name;
            item.appendChild(item_name);

            /*
            const item_img_url = data.image_path;
            const item_img = document.createElement("img");
            item_img.setAttribute("src", item_img_url);
            item.appendChild(item_img);
            

            const price = document.createElement("p");
            price.innerHTML = data.price;
            item.appendChild(price);

            const desc = document.createElement("p");
            desc.innerHTML = data.description;
            item.appendChild(desc);
            
            */
            shop.appendChild(item);
            
            
        }
        else{
            console.log("fail");
        }
    }  
    catch (err){
        console.log(err);
    }
}