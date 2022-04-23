export const fetchBackend = ( endpoint, data, method= 'GET')=>
{
    const url = `http://localhost:8080/api/${endpoint}`;

    if(method ==='GET')
    {
        return fetch(url);
    }
    else{
        return fetch(url, {
            method,
            headers:{
                'Content-type': 'application/json'
            },
            body:JSON.stringify(data)
        });
    }
}